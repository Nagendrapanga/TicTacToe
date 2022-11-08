import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener
{
      Random random = new Random();
      JFrame frame = new JFrame();
      JPanel title_panel = new JPanel();
      JPanel button_panel = new JPanel();
      JLabel textfield = new JLabel();
      JButton[] button = new JButton[9];

      boolean player1_turn;
      TicTacToe(){
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setSize(800,800);
          frame.getContentPane().setBackground(new Color(50,50,50));
          frame.setLayout(new BorderLayout());
          frame.setVisible(true);

          textfield.setBackground(new Color(25,25,25));
          textfield.setFont(new Font("Ink Tree",Font.BOLD,75));
          textfield.setText("TicTacToe");
          textfield.setOpaque(true);

          title_panel.setLayout(new BorderLayout());
          title_panel.setBounds(0,0,800,100);

          button_panel.setLayout(new GridLayout(3,3));
          button_panel.setBackground(new Color(150,150,150));

          for(int i = 0; i < 9; i++)
          {
              button[i] = new JButton();
              button_panel.add(button[i]);
              button[i].setFont(new Font("MV Boli",Font.BOLD,120));
              button[i].setFocusable(false);
              button[i].addActionListener(this);
          }
          title_panel.add(textfield);
          frame.add(title_panel,BorderLayout.NORTH);
          frame.add(button_panel);
         firstturn();
      }
      public void actionPerformed(ActionEvent e)
      {
         for(int i=0;i<9;i++)
         {
             if(e.getSource()==button[i])
             {
                 if(player1_turn==true)
                 {
                     if(button[i].getText()=="")
                     {
                         button[i].setForeground(new Color(250,0,0));
                         button[i].setText("X");
                         player1_turn=false;
                         textfield.setText("0 Turn");
                        check();
                     }
                 }
                 else
                 {
                     if(button[i].getText()=="")
                     {
                         button[i].setForeground(new Color(0,0,255));
                         button[i].setText("0");
                         player1_turn=true;
                         textfield.setText("X Turn");
                         check();
                     }
                 }
             }
         }
      }
      public void firstturn()
        {
          try
          {
              Thread.sleep(2000);
          }
          catch(InterruptedException e)
          {
              e.printStackTrace();
          }
          if(random.nextInt(2)==0)
          {
             player1_turn=true;
             textfield.setText("X Turn");
          }
          else
          {
              player1_turn=false;
              textfield.setText("0 Turn");
          }
        }
        public void check()
        {
           // Condiions for X wins;

          // Horizontal  i am checking;
          if(button[0].getText()=="X" && button[1].getText()=="X" && button[2].getText()=="X"){
              xwin(0,1,2);
          }
          if(button[3].getText()=="X" && button[4].getText()=="X" && button[5].getText()=="X"){
                xwin(3,4,5);
            }
          if(button[6].getText()=="X" && button[7].getText()=="X" && button[8].getText()=="X"){
                xwin(6,7,8);
            }
          //vertical i am checking;

            if(button[0].getText()=="X" && button[3].getText()=="X" && button[6].getText()=="X"){
                xwin(0,3,6);
            }
            if(button[1].getText()=="X" && button[4].getText()=="X" && button[7].getText()=="X"){
                xwin(1,4,7);
            }
            if(button[2].getText()=="X" && button[5].getText()=="X" && button[8].getText()=="X"){
                xwin(2,5,8);
            }
            // Diagonal;
            if(button[0].getText()=="X" && button[4].getText()=="X" && button[8].getText()=="X"){
                xwin(0,4,8);
            }
            if(button[2].getText()=="X" && button[4].getText()=="X" && button[6].getText()=="X"){
                xwin(2,4,6);
            }
            // 0 wins;

            // Horizontal  i am checking;
            if(button[0].getText()=="0" && button[1].getText()=="0" && button[2].getText()=="0"){
                owin(0,1,2);
            }
            if(button[3].getText()=="0" && button[4].getText()=="0" && button[5].getText()=="0"){
                owin(3,4,5);
            }
            if(button[6].getText()=="0" && button[7].getText()=="0" && button[8].getText()=="0"){
                owin(6,7,8);
            }
            //vertical i am checking;

            if(button[0].getText()=="0" && button[3].getText()=="0" && button[6].getText()=="0"){
                owin(0,3,6);
            }
            if(button[1].getText()=="0" && button[4].getText()=="0" && button[7].getText()=="0"){
                owin(1,4,7);
            }
            if(button[2].getText()=="0" && button[5].getText()=="0" && button[8].getText()=="0"){
                owin(2,5,8);
            }
            // Diagonal;
            if(button[0].getText()=="0" && button[4].getText()=="0" && button[8].getText()=="0"){
                owin(0,4,8);
            }
            if(button[2].getText()=="0" && button[4].getText()=="0" && button[6].getText()=="0"){
                owin(2,4,6);
            }
        }
        public void xwin(int a,int b,int c)
        {
          button[a].setBackground(Color.GREEN);
          button[b].setBackground(Color.GREEN);
          button[c].setBackground(Color.GREEN);
          textfield.setText("X wins");
          for(int i=0;i<9;i++)
          {
              button[i].setEnabled(false);
          }
        }
        public void owin(int a,int b,int c)
       {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        textfield.setText("0 wins");
        for(int i=0;i<9;i++)
        {
            button[i].setEnabled(false);
        }
       }
}
