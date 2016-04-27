package net.greenrivertech.stacey.quizapp2;

/**
 * Created by Stacey on 4/25/2016.
 */
public class questions
{
    private int question;
    private boolean answer;

    public questions(int question, boolean answer)
    {
        question = this.question;
        answer = this.answer;
    }

   public int getQuestion()
   {
       return question;
   }

   public void setQuestion()
   {
       this.question = question;
   }

   public boolean isAnswer()
   {
       return answer;
   }

   public void setAnswer()
   {
       this.answer = answer;
   }
}
