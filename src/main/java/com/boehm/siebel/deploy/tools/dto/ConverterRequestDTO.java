package com.boehm.siebel.deploy.tools.dto;

/**
 * Created by boechr on 16.05.2017.
 */
public class ConverterRequestDTO {
    public enum ConvertType {
        TAB_TO_JIRA ("TAB_TO_JIRA", "Tab to JIRA"),
        ROWID_TO_SIEBELQL ("ROWID_TO_SIEBELQL", "RowId to SiebelQL ([Id]='XXX')"),
        OR_CONNECTED ("OR_CONNECTED", "OR-Verknüpft ('XXX' OR 'YYY')"),
        COMMA_CONNECTED ("COMMA_CONNECTED", "Komma-Verknüpft ('XXX', 'YYY')"),
        SIEBPS_TO_STRUCTURE ("SIEBPS_TO_STRUCTURE", "PropertySet to Structured Display");

        private final String shortName;
        private final String fullName;

        ConvertType(String shortName, String fullName) {
            this.shortName = shortName;
            this.fullName = fullName;
        }

        public String getShortName() {
            return shortName;
        }

        @org.jetbrains.annotations.Contract(pure = true)
        public String getFullName() {
            return fullName;
        }
    };

    private ConvertType convertType;
    private String request;
    private boolean headerAvailable;

    public boolean isHeaderAvailable() {
        return headerAvailable;
    }

    public void setHeaderAvailable(boolean headerAvailable) {
        this.headerAvailable = headerAvailable;
    }

    public ConvertType getConvertType() {
        return convertType;
    }

    public void setConvertType(ConvertType convertType) {
        this.convertType = convertType;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
