package com.vkexample.tictoctoy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.vkexample.tictoctoy.databinding.ActivityMainBinding;

import java.util.Random;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean flag;
    private ActivityMainBinding binding;
    private Random random;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        random = new Random();
        flag = true;
        binding.tv11.setOnClickListener(this);
        binding.tv12.setOnClickListener(this);
        binding.tv13.setOnClickListener(this);

        binding.tv21.setOnClickListener(this);
        binding.tv22.setOnClickListener(this);
        binding.tv23.setOnClickListener(this);

        binding.tv31.setOnClickListener(this);
        binding.tv32.setOnClickListener(this);
        binding.tv33.setOnClickListener(this);

        binding.newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ResultActivity.class));

            }
        });
    }
    private void doAction(int value) {
        if (value == R.id.tv11) {
            binding.tv11.setText(flag ? "X" : "O");
            binding.tv11.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv12) {
            binding.tv12.setText(flag ? "X" : "O");
            binding.tv12.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv13) {
            binding.tv13.setText(flag ? "X" : "O");
            binding.tv13.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv21) {
            binding.tv21.setText(flag ? "X" : "O");
            binding.tv21.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv22) {
            binding.tv22.setText(flag ? "X" : "O");
            binding.tv22.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv23) {
            binding.tv23.setText(flag ? "X" : "O");
            binding.tv23.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv31) {
            binding.tv31.setText(flag ? "X" : "O");
            binding.tv31.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv32) {
            binding.tv32.setText(flag ? "X" : "O");
            binding.tv32.setClickable(false);
            flag = !flag;
        } else if (value == R.id.tv33) {
            binding.tv33.setText(flag ? "X" : "O");
            binding.tv33.setClickable(false);
            flag = !flag;
        }
    }

    @Override
    public void onClick(View v) {
        doAction(v.getId());
        winnerLogic();
        if(!flag && isCellAvailable()) {
            computerMove();
            winnerLogic();
        }
    }
    private boolean isCellAvailable() {
        if(binding.tv11.isClickable()||binding.tv12.isClickable()||binding.tv13.isClickable()
                || binding.tv21.isClickable()||binding.tv22.isClickable()||binding.tv23.isClickable()
                || binding.tv31.isClickable()||binding.tv32.isClickable()||binding.tv33.isClickable()){
            return true;
        }
        if(binding.showResult.length() <= 0)
            binding.showResult.setText("Game Draw..");
        return false;
    }
    private void computerMove() {
        int compMovePosition = random.nextInt((9-1) +1)+ 1;
//        Log.i(TAG, "computerMove: "+ compMovePosition);

        if (1 == compMovePosition && binding.tv11.isClickable()) {
            doAction(R.id.tv11);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (2 == compMovePosition && binding.tv12.isClickable()) {
            doAction(R.id.tv12);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (3 == compMovePosition && binding.tv13.isClickable()) {
            doAction(R.id.tv13);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (4 == compMovePosition && binding.tv21.isClickable()) {
            doAction(R.id.tv21);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (5 == compMovePosition && binding.tv22.isClickable()) {
            doAction(R.id.tv22);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (6 == compMovePosition && binding.tv23.isClickable()) {
            doAction(R.id.tv23);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (7 == compMovePosition && binding.tv31.isClickable()) {
            doAction(R.id.tv31);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (8 == compMovePosition && binding.tv32.isClickable()){
            doAction(R.id.tv32);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else if (9 == compMovePosition && binding.tv33.isClickable()){
            doAction(R.id.tv33);
            Log.i(TAG, "computerMove: " + compMovePosition);
        }
        else {
            Log.i(TAG, "computerMove Wrong: " + compMovePosition);

            computerMove();
        }
    }
    private void winnerLogic(){
        if(firstRow() || firstColumn() || firstDiagonal()) {
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(firstRow() || secondColumn()){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(firstRow() || thirdColumn() || secondDigonal()){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(firstColumn() || secondRow()) {
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(secondRow() || secondColumn() || firstDiagonal() || secondDigonal()){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(thirdColumn() || secondColumn() ){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(firstRow() || thirdColumn() || secondDigonal()) {
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(thirdRow() || secondColumn()){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }else if(thirdColumn() || thirdRow() || firstDiagonal()){
            binding.showResult.setText(!flag?"You'r Winner":"Computer Winner");
            setClickableVisibility();
        }
    }
    private boolean setClickableVisibility(){
        binding.tv11.setClickable(false);
        binding.tv12.setClickable(false);
        binding.tv13.setClickable(false);

        binding.tv21.setClickable(false);
        binding.tv22.setClickable(false);
        binding.tv23.setClickable(false);

        binding.tv31.setClickable(false);
        binding.tv32.setClickable(false);
        binding.tv33.setClickable(false);
        return false;
    }
    private boolean firstRow(){
        return (binding.tv11.getText() == "X" && binding.tv12.getText() == "X" && binding.tv13.getText() == "X")
                || (binding.tv11.getText() == "O" && binding.tv12.getText() == "O" && binding.tv13.getText() == "O") ;
    }
    private boolean secondRow(){
        return (binding.tv21.getText() == "X" && binding.tv22.getText() == "X" && binding.tv23.getText() == "X") ||
                (binding.tv21.getText() == "O" && binding.tv22.getText() == "O" && binding.tv23.getText() == "O");
    }
    private boolean thirdRow(){
        return (binding.tv31.getText() == "X" && binding.tv32.getText() == "X" && binding.tv33.getText() == "X")
                || (binding.tv31.getText() == "O" && binding.tv32.getText() == "O" && binding.tv33.getText() == "O");
    }
    private boolean firstColumn(){
        return (binding.tv11.getText() == "X" && binding.tv21.getText() == "X" && binding.tv31.getText() == "X")
                || (binding.tv11.getText() == "O" && binding.tv21.getText() == "O" && binding.tv31.getText() == "O");
    }
    private boolean secondColumn(){
        return (binding.tv12.getText() == "X" && binding.tv22.getText() == "X" && binding.tv32.getText() == "X")
                || (binding.tv12.getText() == "O" && binding.tv22.getText() == "O" && binding.tv32.getText() == "O");
    }
    private boolean thirdColumn(){
        return (binding.tv13.getText() == "X" && binding.tv23.getText() == "X" && binding.tv33.getText() == "X")
                || (binding.tv13.getText() == "O" && binding.tv23.getText() == "O" && binding.tv33.getText() == "O");
    }
    private boolean firstDiagonal(){
        return (binding.tv11.getText() == "X" && binding.tv22.getText() == "X" && binding.tv33.getText() == "X")
                || (binding.tv11.getText() == "O" && binding.tv22.getText() == "O" && binding.tv33.getText() == "O");
    }
    private boolean secondDigonal(){
        return (binding.tv13.getText() == "X" && binding.tv22.getText() == "X" && binding.tv31.getText() == "X")
                || (binding.tv13.getText() == "O" && binding.tv22.getText() == "O" && binding.tv31.getText() == "O");
    }
    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}