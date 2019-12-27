package com.company;

public class TicTacToe {
    String[][] grid = new String[3][3];
    private boolean isX = true;

    public TicTacToe() {
        fillGrid();
    }

    public boolean positionIsFree(int position){

        if (Integer.valueOf(position) < 1 || Integer.valueOf(position) > 9){
            return false;
        }

        int i = (position-1) / 3;
        int j = (position-1) % 3;

        if(grid[i][j].equals("X") || grid[i][j].equals("O")){
            return false;
        }
        return true;
    }

    public void placeChar(int position){
        int i = (position-1) / 3;
        int j = (position-1) % 3;

        String charToPlace = this.isX ? "X" : "O";
        this.isX = !this.isX;

        this.grid[i][j] = charToPlace;
    }

    public boolean playerHasWon(){
        // rows
        for (int r = 0; r < 3; r++) {
            if (this.grid[r][0].equals(this.grid[r][1]) && this.grid[r][1].equals(this.grid[r][2]))
                return true;
        }
        //columns
        for (int c = 0; c < 3; c++) {
            if (this.grid[0][c].equals(this.grid[1][c]) && this.grid[1][c].equals(this.grid[2][c]))
                return true;
        }
        //diagonals
        if (this.grid[0][0].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][2]))
            return true;

        if (this.grid[0][2].equals(this.grid[1][1]) && this.grid[1][1].equals(this.grid[2][0]))
            return true;

        return false;
    };

    public boolean isDraw(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String curElement = grid[i][j];
                if (!curElement.equals("X") && !curElement.equals("O")){
                    return false;
                }
            }
        }
        return true;
    }

    private void fillGrid(){
        int val = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = String.valueOf(val);
                val +=1;
            }
        }
    }

    public void printGrid(){
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("("+grid[i][j]+")" + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}