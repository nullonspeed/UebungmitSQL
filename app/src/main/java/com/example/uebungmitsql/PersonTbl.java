package com.example.uebungmitsql;

public class PersonTbl {
    public static final String TABLE_NAME= "Patients";

    public static final String ID ="ID";
    public static final String Firstname= "Firstname";
    public static final String Lastname = "Lastname";

    public static final String SQL_CREATE=
                "CREATE TABLE "+ TABLE_NAME +
                        "("+
                        ID + " INTEGER PRIMARY KEY,"+
                        Firstname + " TEXT NOT NULL,"+
                        Lastname + " TEXT NOT NULL)";

    public static final String STMT_INSERT=
            "INSERT INTO " + TABLE_NAME+
                    "("+Firstname+","+Lastname+")"+
                    "VALUES(?,?)";

    public static final String SQL_DROP="DROP TABLE IF EXISTS "+ TABLE_NAME;
}
