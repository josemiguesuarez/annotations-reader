package processor;

import java.util.HashMap;
import java.util.List;

import code.annotation.MyAnnotation;
import generated.And;
import generated.Feature;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Struct;
import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;

public class Processor extends AbstractProcessor<CtAnnotation<MyAnnotation>>{
	HashMap<String, And> map;
	Struct struct;
	ObjectFactory of;
	FeatureModel fm;
	And and;
	@Override
	public void init() {
		map = new HashMap<String, And>();
		System.out.println("Empieza procesamiento");
		super.init();
		of = new ObjectFactory();
		struct = of.createStruct();
		
		fm = of.createFeatureModel();
		fm.setStruct(struct);
		
		and = of.createAnd();
		and.setName("biblioteca");
		struct.setAnd(and);
	}
	@Override
	public void process(CtAnnotation<MyAnnotation> annotation) {
		String attributeValue = annotation.getActualAnnotation().myAttribute();
		String mandatory = annotation.getActualAnnotation().mandatory();
		System.out.println("Anotacion encontrada, atributo: "+attributeValue);
		
		System.out.println("\t usada en: "+annotation.getParent().getShortRepresentation());
		
		Feature feature = of.createFeature();
		String nombreClase = annotation.getParent().getShortRepresentation();
		if(nombreClase.contains(".")){
			String[] nombres = nombreClase.split("\\.");
			nombreClase = nombres[nombres.length-1];
			String nombrePackage = nombres[nombres.length-2];
			And andPackage = map.get(nombrePackage);
			if(andPackage == null){
				andPackage = new And();
				andPackage.setName(nombrePackage);
				List<Object> list = and.getAndOrAltOrOr();
				list.add(andPackage);
				map.put(nombrePackage, andPackage);
			}
			
			
			feature.setName(nombreClase);
			feature.setMandatory(mandatory.equals("true")?true:false);
			List<Object> list = andPackage.getAndOrAltOrOr();
			list.add(feature);
		}
		
		
		
		
		
	}
	
	@Override
	public void processingDone() {
		System.out.println("Termina procesamiento");
		super.processingDone();
		JaxbWriterReader.jaxbWriterNoSchema(fm, "result/result.xml");
	}

}
