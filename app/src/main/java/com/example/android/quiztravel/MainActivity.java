package com.example.android.quiztravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean answerOneBrasilia;
    private boolean answerOneSaoPaulo;
    private boolean answerOneBeloHorizonte;
    private boolean answerOneNatal;

    private boolean answerRioJaneiro;
    private boolean answerPara;
    private boolean answerCeara;
    private boolean answerAmazonas;

    private boolean answerYes;
    private boolean answerNo;

    private int quantityStates = 0;
    private String opiniao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void send(View view) {
        RadioButton rdAnswerOneZero = (RadioButton) findViewById(R.id.brasilia);
        answerOneBrasilia = rdAnswerOneZero.isChecked();

        RadioButton rdAnswerOneOneOrTwo = (RadioButton) findViewById(R.id.saoPaulo);
        answerOneSaoPaulo = rdAnswerOneOneOrTwo.isChecked();

        RadioButton rdAnswerOneThreeOrFour = (RadioButton) findViewById(R.id.beloHorizonte);
        answerOneBeloHorizonte = rdAnswerOneThreeOrFour.isChecked();

        RadioButton rdAnswerOneMoreThanFour = (RadioButton) findViewById(R.id.natal);
        answerOneNatal = rdAnswerOneMoreThanFour.isChecked();

        CheckBox chkAnswerPeopleAlone = (CheckBox) findViewById(R.id.rioJaneiro);
        answerRioJaneiro = chkAnswerPeopleAlone.isChecked();

        CheckBox chkAnswerPeopleCouple = (CheckBox) findViewById(R.id.para);
        answerPara = chkAnswerPeopleCouple.isChecked();

        CheckBox chkAnswerPeopleThreeOrFour = (CheckBox) findViewById(R.id.ceara);
        answerCeara = chkAnswerPeopleThreeOrFour.isChecked();

        CheckBox chkAnswerPeopleMoreThanFour = (CheckBox) findViewById(R.id.amazonas);
        answerAmazonas = chkAnswerPeopleMoreThanFour.isChecked();

        RadioButton rdAnsweYes = (RadioButton) findViewById(R.id.sim);
        answerYes = rdAnsweYes.isChecked();

        RadioButton rdAnswerNo = (RadioButton) findViewById(R.id.nao);
        answerNo = rdAnswerNo.isChecked();

        EditText editText = (EditText) findViewById(R.id.input_name);
        opiniao = (editText.getText()).toString();

        displayAnswer();

    }

    public void displayAnswer() {
        String answer = "";
        int quantidadeCerta = 1;

        if (answerOneBrasilia) {
            quantidadeCerta++;
        }
        if (answerPara && answerAmazonas && !answerRioJaneiro && !answerCeara) {
            quantidadeCerta++;
        }

        if (quantityStates == 26) {
            quantidadeCerta++;
        }

        if (answerNo) {
            quantidadeCerta++;
        }

        if (opiniao.equals("Sergipe")) {
            quantidadeCerta++;
        }
        answer = "Você acertou " + quantidadeCerta + " respostas!\n";
        if (quantidadeCerta < 3) {
            answer += "Que pena!\nVocê precisa conhecer um pouco mais sobre nosso pais.";
        } else if (quantidadeCerta < 5) {
            answer += "Parabéns!\nVocê conhece bastante sobre o Brasil.";
        } else {
            answer += "UAU!\nVocê acertou todas as resposta.";
        }
        Toast.makeText(this, answer, Toast.LENGTH_SHORT).show();
    }

    public void increment(View view) {
        if (quantityStates < 100) {
            quantityStates++;
            displayQuantity(quantityStates);
        } else {
            Toast.makeText(this, "A quantidade máxima é 100.", Toast.LENGTH_SHORT).show();
        }
    }

    public void decrement(View view) {
        if (quantityStates > 1) {
            quantityStates--;
            displayQuantity(quantityStates);
        } else {
            Toast.makeText(this, "A quantidade minima é 1.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method displays the given quantityStates value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}
