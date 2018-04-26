/**
 * NAME:- BRIAN NDUNGU
 * TEACHER:- MR.HARDMAN
 * COURSE:- CS40S
 * LAST MODIFIED:- 4/26/2018
 */
package combrianndungu254.httpsgithub.palindromecheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private EditText mInputDisplay;
    private TextView mErrorDisplay;
    private TextView mPalindromeCheck;



    @Override
    /**
     * onCreate is the method that is executed  when the activity begins
     *
     * @param savedInstanceState is a bundle of data used to restore the activity from a previous instance
     * @return nothing is returned
     */
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputDisplay = (EditText) findViewById(R.id.et_input_display);
        mErrorDisplay = (TextView) findViewById(R.id.tv_error_messsage);
        mPalindromeCheck = (TextView) findViewById(R.id.tv_check_palindrome);



        mInputDisplay.addTextChangedListener(textInputWatcher);
    }

    private final TextWatcher textInputWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        /**
         * afterTextChanged is the method that is called once the text has changed in an Editable object
         * @param result is the the object that shows the user if the word is a palindrome or not
         * @return Nothing is returned
         */
        public void afterTextChanged(Editable editable) {
            String userWord;
            boolean result;

            if (editable.length() == 0) {
                mPalindromeCheck.setText("");
                mErrorDisplay.setText(" you MUST enter a WORD to check if its a palindrome");
            } else if (editable.toString().contains(" ")) {
                mErrorDisplay.setText("BLANK SPACES are not ALLOWED");
                mPalindromeCheck.setText("");
            } else {
                userWord = mInputDisplay.getText().toString().toUpperCase();
                mPalindromeCheck.setText("");
                mErrorDisplay.setText("");


                result = checkPalindrome(userWord, 0);

                if (result == true)
                {
                    mPalindromeCheck.setText(userWord + " is a PALINDROME");
                }
                else
                {
                    mPalindromeCheck.setText(userWord + " is NOT a PALINDROME");
                }
            }

        }
    };

    /**
     *
     * @param userWord is the current word being evaluated if it is a palindrome
     * @param currentIndex stores the current word
     * @return userWord is returned
     */
   private boolean checkPalindrome(String userWord, int currentIndex)
    {
        boolean result;

        int indexFromEnd = userWord.length() - currentIndex - 1;

        if( userWord.charAt(currentIndex) == userWord.charAt(indexFromEnd) )
        {
            if( currentIndex == indexFromEnd || currentIndex == indexFromEnd - 1 )
            {
                result = true;
            }
            else
            {
                result = checkPalindrome(userWord, currentIndex + 1);
            }
        }
        else
        {
            result = false;
        }

        return result;

    }
}
