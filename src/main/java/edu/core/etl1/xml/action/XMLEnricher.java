package edu.core.etl1.xml.action;

import edu.core.etl1.common.Enricher;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.target.XMLTarget;

public class XMLEnricher implements Enricher<String, XMLTarget> {

    @Override
    public XMLTarget enrich(String header, XMLTarget target) throws BaseException {
        // TODO enrich logic here or separate class which implements Enricher interface
        System.out.println("enricher : " + header + " " + target);
        return target;
    }
}
