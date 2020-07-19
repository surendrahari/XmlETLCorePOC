package edu.core.etl1.xml.action;

import edu.core.etl1.common.Parser;
import edu.core.etl1.common.exception.BaseException;
import edu.core.etl1.xml.model.source.XMLSource;

public class XMLParser implements Parser<String, String, XMLSource> {

    @Override
    public XMLSource parse(String header, String message) throws BaseException {
        int count = 0;
        XMLSource source = new XMLSource();
        for (String splitData : message.split(",")) {
            if (count == 0) {
                source.setId(splitData);
            } else if (count == 1) {
                source.setName(splitData);
            } else if (count == 2) {
                source.setNetAmount(splitData);
            }
            count++;
        }
        System.out.println("parser  : header=" + header + ", message=" + message + ", source=" + source);
        return source;
    }
}
