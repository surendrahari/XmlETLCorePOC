package edu.core.etl1.xml.action;

import edu.core.etl1.common.Poster;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.target.XMLTarget;

public class XMLPoster implements Poster<String, XMLTarget> {
    @Override
    public XMLTarget post(String header, XMLTarget target) throws BaseException {
        // TODO Poster logic here or separate class which implements Poster interface
        System.out.println("poster : " + header + " " + target);
        return target;
    }
}
