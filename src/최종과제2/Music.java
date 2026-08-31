package 최종과제2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;;

public class Music extends JFrame {
    private Clip clip;
    private JProgressBar progressBar;
    private JLabel label3;

    Music() {
        super("재생화면");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 700);

        loadAudio("audio/Baddie.wav");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(new MainPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    private void loadAudio(String pathName) {
        try {
            clip = AudioSystem.getClip();
            File audioFile = new File(pathName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    class MyActionListener implements ActionListener {
        private boolean isPaused = false;

        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "▶":
                    isPaused = false;
                    clip.start();
                    startProgressBar();
                    break;
                case "II":
                    isPaused = true;
                    clip.stop();
                    stopProgressBar();
                    break;
                case "⟳":
                    isPaused = false;
                    clip.setFramePosition(0);
                    clip.start();
                    startProgressBar();
                    break;
            }
        }

        private void startProgressBar() {
            new Thread(() -> {
                while (clip.isRunning()) {
                    progressBar.setValue(clip.getFramePosition());
                    if (!isPaused) {
                        updateLabel();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }).start();
        }

        private void stopProgressBar() {
            progressBar.setValue(clip.getFramePosition());
            if (!isPaused) {
                updateLabel();
            }
        }

        private void updateLabel() {
            int seconds = clip.getFramePosition() / (int) clip.getFormat().getFrameRate();
            int minutes = seconds / 60;
            int remainingSeconds = seconds % 60;

            label3.setText(String.format("%d:%02d", minutes, remainingSeconds));
        }
    }

    class MainPanel extends JPanel {
        MainPanel() {
            setLayout(null);
            setBackground(Color.BLACK);

            Font font1 = new Font("HY견고딕 보통", Font.BOLD, 20);
            Font font2 = new Font("HY견고딕 보통", Font.PLAIN, 15);

            JLabel label1 = new JLabel("Baddie");
            label1.setForeground(Color.WHITE);
            label1.setFont(font1);

            JButton label2 = new JButton("IVE (아이브)");
            label2.setForeground(Color.WHITE);
            label2.setBorder(new LineBorder(Color.BLACK));
            label2.setBackground(Color.BLACK);
            label2.setFont(font2);
            
         // 하이퍼링크를 열기 위한 ActionListener 추가
            label2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // 여기에 열고자 하는 웹 페이지의 URL을 입력하세요
                        URI uri = new URI("https://namu.wiki/w/IVE");
                        Desktop.getDesktop().browse(uri);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

            label1.setSize(100, 20);
            label2.setSize(90, 20);

            label1.setLocation(15, 10);
            label2.setLocation(14, 30);

            add(label1);
            add(label2);

            ImageIcon img = new ImageIcon("./images/Baddie.jpg");

            JButton btnimg = new JButton(img);
            btnimg.setBounds(15, 55, 355, 355);
            btnimg.setBorder(new LineBorder(Color.BLACK));
            
         // 하이퍼링크를 열기 위한 ActionListener 추가
            btnimg.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // 여기에 열고자 하는 웹 페이지의 URL을 입력하세요
                        URI uri = new URI("https://namu.wiki/w/I'VE%20MINE");
                        Desktop.getDesktop().browse(uri);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
            add(btnimg);

            MyActionListener al = new MyActionListener();

            Font font3 = new Font("Impact 보통", Font.BOLD, 50);
            Font font4 = new Font("Impact 보통", Font.BOLD, 60);

            JButton play = new JButton("▶");
            play.setBounds(170, 550, 60, 60);
            play.setBorder(new LineBorder(Color.BLACK));
            play.setFont(font3);
            play.setForeground(Color.WHITE);
            play.setBackground(Color.BLACK);
            play.addActionListener(al);

            JButton btn2 = new JButton("II");
            btn2.setBounds(80, 550, 60, 60);
            btn2.setBorder(new LineBorder(Color.BLACK));
            btn2.setFont(font3);
            btn2.setForeground(Color.WHITE);
            btn2.setBackground(Color.BLACK);
            btn2.addActionListener(al);

            JButton btn3 = new JButton("⟳");
            btn3.setBounds(250, 545, 60, 60);
            btn3.setBorder(new LineBorder(Color.BLACK));
            btn3.setFont(font4);
            btn3.setForeground(Color.WHITE);
            btn3.setBackground(Color.BLACK);
            btn3.addActionListener(al);

            JButton btn4 = new JButton("가사");
            btn4.setBounds(150, 445, 90, 30);
            btn4.setBorder(new LineBorder(Color.BLACK));
            btn4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Lyrics lyricsFrame = new Lyrics(Music.this);
                    lyricsFrame.setVisible(true);
                }
            });

            Font font5 = new Font("HY견고딕 보통", Font.PLAIN, 12);
            label3 = new JLabel("0:00");
            label3.setForeground(Color.WHITE);
            label3.setFont(font5);
            label3.setSize(100, 20);
            label3.setLocation(35, 520);
            add(label3);

            JLabel label4 = new JLabel("02:34");
            label4.setForeground(Color.WHITE);
            label4.setFont(font5);

            label4.setSize(100, 20);
            label4.setLocation(325, 520);
            add(label4);

            // 진행 바 초기화
            progressBar = new JProgressBar(0, clip.getFrameLength());
            progressBar.setValue(0);

            // 진행 바의 색상 변경 (녹색)
            progressBar.setForeground(Color.GREEN);

            // 진행 바의 위치 변경 (하단에 배치)
            progressBar.setBounds(35, 510, 320, 10);
            add(play);
            add(btn2);
            add(btn3);
            add(btn4);
            add(progressBar); // 진행 바 추가
        }
    }

    public static void main(String[] args) {
        new Music();
    }
}