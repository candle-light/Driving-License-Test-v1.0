package com.badcompany.licensetest;

/**
 * Created by Donatas on 29/08/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.badcompany.licensetest.Question_Constant.QuestionTable;

import java.util.ArrayList;
import java.util.List;


public  class DatabaseHelper extends SQLiteOpenHelper {
    //public abstract class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "LtestDB.db";
    private static final int DATABASE_VERSION = 1;

    private Context mContext;
    private SQLiteDatabase db;

    //private Dao<Question, Integer> QuestionDao = null;
    //private RuntimeExceptionDao<Question, Integer> QuestionRuntimeDao = null;



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        this.db = db;
        final String SQL_CREAT_QUESTIONS = "CREATE TABLE `Questions` (\n" +
                "\t`id`\tINTEGER NOT NULL,\n" +
                "\t`question`\tTEXT NOT NULL,\n" +
                "\t`imagename`\tTEXT,\n" +
                "\t`category`\tTEXT,\n" +
                "\t`answera`\tTEXT,\n" +
                "\t`answerb`\tTEXT,\n" +
                "\t`answerc`\tTEXT,\n" +
                "\t`answerd`\tTEXT,\n" +
                "\tPRIMARY KEY(`id`)\n" +
                ");";
        db.execSQL(SQL_CREAT_QUESTIONS);
        fillQuestionsTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }
    private void fillQuestionsTable(){
        Question q1 = new Question("Questions is ..", "Image is", " Category is..", "A answer is..", "B answer is..", "C answer is..", "D answer is..");
        Question q2 = new Question("Questions 2 is ..", "Image is", " Category is..", "A answer is..", "B answer is..", "C answer is..", "D answer is..");
        addQuestion(q1);
        addQuestion(q2);

    }

    private void addQuestion(Question q){
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, q.getQuestion());
        cv.put(QuestionTable.COLUMN_IMAGE, q.getImagename());
        cv.put(QuestionTable.COLUMN_CATEGORY, q.getCategory());
        cv.put(QuestionTable.COLUMN_ANSWERA, q.getAnswera());
        cv.put(QuestionTable.COLUMN_ANSWERB, q.getAnswerb());
        cv.put(QuestionTable.COLUMN_ANSWERC, q.getAnswerc());
        cv.put(QuestionTable.COLUMN_ANSWERD, q.getAnswerd());
        db.insert(QuestionTable.TABLE_NAME,null, cv);
    }
    public List<Question> getAllQuestions(){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+ QuestionTable.TABLE_NAME, null);
        if(c.moveToFirst()){
            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setImagename(c.getString(c.getColumnIndex(QuestionTable.COLUMN_IMAGE)));
                question.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                question.setAnswera(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWERA)));
                question.setAnswerb(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWERB)));
                question.setAnswerc(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWERC)));
                question.setAnswerd(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANSWERD)));
                questionList.add(question);

            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
    
    /*@Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource){try{TableUtils.createTable(connectionSource,Question.class);}catch(SQLException e){e.printStackTrace();}}
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion)
     {try {TableUtils.dropTable(connectionSource, Question.class, true);onCreate(database, connectionSource);} catch (SQLException e) {e.printStackTrace();}}*/

    public void openDatabase(){
        String dbpath = mContext.getDatabasePath(DATABASE_NAME).getPath();
        if(db != null && db.isOpen()){
            return ;
        }
        db = SQLiteDatabase.openDatabase(dbpath, null, SQLiteDatabase.OPEN_READWRITE);
    }


    public void closeDatabase(){
        if(db != null)
            db.close();
    }



    /*public Dao<Question, Integer> getDao(){
        if(QuestionDao == null){
            QuestionDao = getDao(Question.class);
        }
        return  QuestionDao;
    }

    public RuntimeExceptionDao<Question, Integer> getRuntimeExceptioonDao(){
        if(QuestionRuntimeDao == null){
            QuestionRuntimeDao = getRuntimeExceptioonDao(Question.class);
        }
        return  QuestionRuntimeDao;
    }*/


}




