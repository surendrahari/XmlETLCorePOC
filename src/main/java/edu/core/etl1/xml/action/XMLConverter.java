package edu.core.etl1.xml.action;

import edu.core.etl1.common.Convertor;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.source.XMLSource;
import edu.core.etl1.xml.model.target.XMLTarget;

import java.math.BigDecimal;

public class XMLConverter implements Convertor<String, XMLSource, XMLTarget> {

    @Override
    public XMLTarget convert(String header, XMLSource source) throws BaseException {
        XMLTarget target = new XMLTarget();
        target.setId(Integer.parseInt(source.getId()));
        target.setName(source.getName());
        target.setNetAmount(new BigDecimal(source.getNetAmount()));
        System.out.println("convertor : " + header + " " + source + " " + target);
        return target;
    }
}
