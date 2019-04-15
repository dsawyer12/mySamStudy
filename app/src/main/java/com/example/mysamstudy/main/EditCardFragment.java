package com.example.mysamstudy.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysamstudy.R;
import com.example.mysamstudy.objects.Card;
import com.example.mysamstudy.utils.DatabaseManager;

public class EditCardFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "TAG";

    TextView toolbar_header;
    EditText card_question, card_answer;
    ImageView finish, back;
    Card card;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar_header = view.findViewById(R.id.edit_card_toolbar_title);
        card_question = view.findViewById(R.id.card_question);
        card_answer=  view.findViewById(R.id.card_answer);
        finish = view.findViewById(R.id.new_card_finish);
        back = view.findViewById(R.id.new_card_back);

        finish.setOnClickListener(this);
        back.setOnClickListener(this);

        card = getCardFromBundle();
        if (card != null)
            initLayout();
    }

    public void initLayout(){
        card_question.setText(card.getCardQuestion());
        card_answer.setText(card.getCardAnswer());
    }

    public void updateCard(){
        if (card_question.getText().toString().trim().isEmpty()){
            card_question.setError("Field is empty");
            card_question.requestFocus();
            return;
        }
        if (card_answer.getText().toString().trim().isEmpty()){
            card_answer.setError("Field is empty");
            card_answer.requestFocus();
        }

        else{
            card.setCardQuestion(card_question.getText().toString().trim());
            card.setCardAnswer(card_answer.getText().toString().trim());

            DatabaseManager dbm = new DatabaseManager(getActivity());
            dbm.updateCard(card);
            getActivity().getSupportFragmentManager().popBackStackImmediate();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.new_card_finish):
                updateCard();
                break;

            case(R.id.new_card_back):

                // if fields are updated, display a dialogue fragment to make sure they want to quit

                getActivity().getSupportFragmentManager().popBackStackImmediate();
                break;
        }
    }

    public Card getCardFromBundle(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            return bundle.getParcelable("editCard");
        }
        else{
            return null;
        }
    }
}













