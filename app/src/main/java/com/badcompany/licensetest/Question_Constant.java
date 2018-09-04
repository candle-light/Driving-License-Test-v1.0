package com.badcompany.licensetest;

import android.provider.BaseColumns;

/**
 * Created by Donatas on 30/08/2018.
 */

public final class Question_Constant {

    private Question_Constant(){}

    public static class QuestionTable implements BaseColumns{
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_IMAGE = "imagename";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_ANSWERA = "answera";
        public static final String COLUMN_ANSWERB = "answerb";
        public static final String COLUMN_ANSWERC = "answerc";
        public static final String COLUMN_ANSWERD = "answerd";
    }
}
