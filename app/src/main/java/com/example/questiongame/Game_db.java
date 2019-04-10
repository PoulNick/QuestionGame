package com.example.questiongame;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Game_db extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game_db";
    private static final int DATABASE_VERSION = 2;

    public static final String QUESTIONS_TABLE = "questions";
    public static final String GAME_COLUMN_ID = "id";
    public static final String GAME_QUESTION = "question";
    public static final String GAME_COLUMN_ANSWER1 = "answer1";
    public static final String GAME_COLUMN_ANSWER2 = "answer2";
    public static final String GAME_COLUMN_ANSWER3 = "answer3";
    public static final String GAME_COLUMN_ANSWER4 = "answer4";
    public static final String GAME_COLUMN_CORECT_ANSWER = "correct_answer";

    public Game_db(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+QUESTIONS_TABLE+" (" +
                GAME_COLUMN_ID+" integer primary key autoincrement, " +
                GAME_QUESTION+" text not null, "+
                GAME_COLUMN_ANSWER1+" text not null, "+
                GAME_COLUMN_ANSWER2+" text not null, "+
                GAME_COLUMN_ANSWER3+" text not null, "+
                GAME_COLUMN_ANSWER4+" text not null, " +
                GAME_COLUMN_CORECT_ANSWER+" text not null)");

        ContentValues values = new ContentValues();
        values.put(GAME_QUESTION, "Πότε έγιναν στην Αθήνα οι Ολυμπιακοί αγώνες");
        values.put(GAME_COLUMN_ANSWER1, " Το 2000");
        values.put(GAME_COLUMN_ANSWER2, "Το 1996");
        values.put(GAME_COLUMN_ANSWER3, "Το 2004");
        values.put(GAME_COLUMN_ANSWER4, "Το 2008");
        values.put(GAME_COLUMN_CORECT_ANSWER, "Το 2004");

        db.insert(QUESTIONS_TABLE, null, values);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}