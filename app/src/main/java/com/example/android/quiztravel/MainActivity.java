package com.example.android.quiztravel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean answerOneZero;
    private boolean answerOneOneOrTwo;
    private boolean answerOneThreeOrFour;
    private boolean answerOneMoreThanFour;

    private boolean answerPeopleAlone;
    private boolean answerPeopleCouple;
    private boolean answerPeopleThreeOrFour;
    private boolean answerPeopleMoreThanFour;

    private boolean answerBedSizeYes;
    private boolean answerBedSizeNo;

    private int quantity = 0;
    private String opiniao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void send(View view) {
        CheckBox chkAnswerOneZero = (CheckBox) findViewById(R.id.viagemZero);
        answerOneZero = chkAnswerOneZero.isChecked();

        CheckBox chkAnswerOneOneOrTwo = (CheckBox) findViewById(R.id.viagemUmaDuas);
        answerOneOneOrTwo = chkAnswerOneOneOrTwo.isChecked();

        CheckBox chkAnswerOneThreeOrFour = (CheckBox) findViewById(R.id.viagemTresQuatro);
        answerOneThreeOrFour = chkAnswerOneThreeOrFour.isChecked();

        CheckBox chkAnswerOneMoreThanFour = (CheckBox) findViewById(R.id.viagemQuatroMais);
        answerOneMoreThanFour = chkAnswerOneMoreThanFour.isChecked();

        CheckBox chkAnswerPeopleAlone = (CheckBox) findViewById(R.id.pessoasSozinho);
        answerPeopleAlone = chkAnswerPeopleAlone.isChecked();

        CheckBox chkAnswerPeopleCouple = (CheckBox) findViewById(R.id.pessoasCasal);
        answerPeopleCouple = chkAnswerPeopleCouple.isChecked();

        CheckBox chkAnswerPeopleThreeOrFour = (CheckBox) findViewById(R.id.pessoasTresQuatro);
        answerPeopleThreeOrFour = chkAnswerPeopleThreeOrFour.isChecked();

        CheckBox chkAnswerPeopleMoreThanFour = (CheckBox) findViewById(R.id.pessoasQuatroMais);
        answerPeopleMoreThanFour = chkAnswerPeopleMoreThanFour.isChecked();

        RadioButton rdAnswerBedSizeYes = (RadioButton) findViewById(R.id.sim);
        answerBedSizeYes = rdAnswerBedSizeYes.isChecked();

        RadioButton rdAnswerBedSizeNo = (RadioButton) findViewById(R.id.nao);
        answerBedSizeNo = rdAnswerBedSizeNo.isChecked();

        EditText editText = (EditText) findViewById(R.id.input_name);
        opiniao = (editText.getText()).toString();

        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
    }

    public void increment(View view) {
        if (quantity < 100) {
            quantity++;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
            displayQuantity(quantity);
        } else {
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}
