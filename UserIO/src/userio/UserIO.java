/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userio;

/**
 *
 * @author benli
 */
public interface UserIO {

    public void print(String message);
    public double readDouble(String prompt);
    public double readDouble(String prompt, double min, double max);
    public float readFloat(String prompt);
    public float readFloat(String prompt, float min, float max);
    public int readInt(String prompt);
    public int readInt(String prompt, int min, int max);
    public long readLong(String prompt);
    public long readLong(String prompt, long min, long max);
    public String readString(String prompt);
}
