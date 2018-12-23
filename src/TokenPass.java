public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount){
        this.board = new int[playerCount];
        for(int i = 0; i<playerCount;i++){
            this.board[i] = (int)(Math.random() * 10)+1;
        }
        this.currentPlayer = (int)(Math.random() * playerCount);
    }


    public void distributeCurrentPlayerTokens(){
        int x = this.board[currentPlayer];
        this.board[currentPlayer]=0;
        int i = currentPlayer+1;
        while(x>0){
            board[i%board.length]++;
            x--;
            i++;
        }
    }

    public void printBoard(){
        for (int i = 0; i <board.length;i++){
            System.out.print("Player "+i+": "+board[i]+" ");
        }
        System.out.println("Current Player: "+currentPlayer);
    }

    public int gameOver(){
        for (int i = 0;i<board.length;i++){
            if(board[i]==0){
                return i;
            }
        }
        return -1;
    }

    public void nextPlayer(){
        currentPlayer = (currentPlayer +1)%board.length;
    }


}
