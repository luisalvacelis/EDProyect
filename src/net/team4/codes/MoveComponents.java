package net.team4.codes;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MoveComponents {
    
    private static MoveComponents instance;
    
    public static MoveComponents getInstance(){
        if(instance==null){
            instance=new MoveComponents();
        }
        return instance;
    }
    
    public void moveComponentYUp(final int start,final int stop,final int delay,final int increment, final JComponent component,final JFrame frame){
        if(component.getY()==start){
            new Thread(){
                @Override
                public void run(){
                    while(component.getY()>stop){
                        for(int i=start;i>=stop;i-=increment){
                            try {
                                Thread.sleep(delay);
                                component.setLocation(component.getX(),i);
                                frame.repaint();
                            } catch (Exception e) {
                                CreateFile.getInstance().writeFileLogs(null, e);
                            }
                        }
                    }
                    component.setLocation(component.getX(), stop);
                    frame.repaint();
                }
            }.start();
        }
    }
    
    public void moveComponentYDown(final int start,final int stop,final int delay,final int increment, final JComponent component,final JFrame frame){
        if(component.getY()==start){
            new Thread(){
                @Override
                public void run(){
                    while(component.getY()<=start){
                        for(int i=start;i<=stop;i+=increment){
                            try {
                                Thread.sleep(delay);
                                component.setLocation(component.getX(),i);
                                frame.repaint();
                            } catch (Exception e) {
                                CreateFile.getInstance().writeFileLogs(null, e);
                            }
                        }
                    }
                    component.setLocation(component.getX(), stop);
                    frame.repaint();
                }
            }.start();
        }
    }
    
    public void moveComponentXLeft(final int start,final int stop,final int delay,final int increment, final JComponent component,final JFrame frame){
        if(component.getX()==start){
            new Thread(){
                @Override
                public void run(){
                    while(component.getX()>stop){
                        for(int i=start;i>=stop;i-=increment){
                            try {
                                Thread.sleep(delay);
                                component.setLocation(i,component.getY());
                                frame.repaint();
                            } catch (Exception e) {
                                CreateFile.getInstance().writeFileLogs(null, e);
                            }
                        }
                    }
                    component.setLocation(stop, component.getY());
                    frame.repaint();
                }
            }.start();
        }
    }
    
    public void moveComponentXRight(final int start,final int stop,final int delay,final int increment, final JComponent component,final JFrame frame){
        if(component.getX()==start){
            new Thread(){
                @Override
                public void run(){
                    while(component.getX() <= start) {
                        for (int i = start; i <= stop; i += increment) {
                            try {
                                Thread.sleep(delay);
                                component.setLocation(i,component.getY());
                                frame.repaint();
                            } catch (Exception e) {
                                CreateFile.getInstance().writeFileLogs(null, e);
                            }
                        }
                    }
                    component.setLocation(stop, component.getY());
                    frame.repaint();
                }
            }.start();
        }
    }
}
