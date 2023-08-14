import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tictactoe extends JFrame implements ActionListener {
    private JButton[][] buttons;
   String currentPlayer = "X";
 
    public Tictactoe() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));
        
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
     

        // set player switch
        if(buttonClicked.getText().equals("")){
            buttonClicked.setText(currentPlayer);
            if(CheckWinner(currentPlayer)){
                JOptionPane.showMessageDialog(this, "Player "+ currentPlayer+ " Wins ");
                Boardreset();
            }
                currentPlayer = (currentPlayer.equals("X"))? "0":"X";//? is ternary operation in java            

        }else{
            JOptionPane.showMessageDialog(this,"This is already acuppied please pick another cell");

        }
        if(Boardfull()){
            JOptionPane.showMessageDialog(this, "The match is draw! Bitches!!");
            Boardreset();

        }

     
       
    }
    //Check Winner
    private boolean CheckWinner(String player){
        for(int row = 0; row<3; row++){
            if(buttons[row][0].getText().equals(player)&&
            buttons[row][1].getText().equals(player)&&
            buttons[row][2].getText().equals(player)){
                return true;
            }
        }
        for(int col = 0; col<3; col++){
            if(buttons[0][col].getText().equals(player)&&
            buttons[1][col].getText().equals(player)&&
            buttons[2][col].getText().equals(player)){
                return true;
            }
        }
        if(buttons[0][0].getText().equals(player)&&
        buttons[1][1].getText().equals(player)&&
        buttons[2][2].getText().equals(player)){
            return true;
        }
        if(buttons[0][2].getText().equals(player)&&
        buttons[1][1].getText().equals(player)&&
        buttons[2][0].getText().equals(player)){
            return true;
        }
        return false;
       
    }
//Check button if full
    private boolean Boardfull(){
        for(int i= 0; i<3; i++){
            for(int j=0; j<3; j++){
                if(buttons[i][j].getText().equals("")){
                    return false;

                }
            }
        }
        return true;
    }

// reset the board
private void Boardreset(){
    for(int i = 0; i<3; i++){
        for(int j =0; j<3; j++){
            buttons[i][j].setText("");
        }
    }

}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tictactoe());
    }
}