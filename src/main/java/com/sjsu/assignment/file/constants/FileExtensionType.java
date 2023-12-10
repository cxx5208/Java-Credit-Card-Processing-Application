package com.sjsu.assignment.file.constants;

public enum FileExtensionType {

    CSV("csv"),
    JSON("json"),
    XML("xml");

    private final String type;

    FileExtensionType(String s)
    {
        type = s;
    }

    public String getType()
    {
        return type;
    }


}
