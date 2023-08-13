import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tictactoe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    
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
        // Handle button click event here

        // set button X to 0
        if (buttonClicked.getText().equals("")) {
            buttonClicked.setText("X");
            if(CheckWinner("X")){
                JOptionPane.showMessageDialog(this, "Player X wins!!");
                Boardreset();
            }
        } else {
        buttonClicked.setText("0");
        if(CheckWinner("0")){JOptionPane.showMessageDialog(this, "Player 0 wins!!"); Boardreset();}
        }
        
        if(Boardfull()&& !CheckWinner("X")&& !CheckWinner("0")){
        JOptionPane.showConfirmDialog(this, "Its a draw");
        Boardreset();}    
        
    
     
       
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
                if(buttons[i][j].getText().equals("X")){
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