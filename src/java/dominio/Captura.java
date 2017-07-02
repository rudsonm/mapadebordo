/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author julio
 */
public class Captura {

    private int id;
    private int lance;
    private float kg;

    public Captura(int id, int lance, float kg) {
        this.id = id;
        this.lance = lance;
        this.kg = kg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLance() {
        return lance;
    }

    public void setLance(int lance) {
        this.lance = lance;
    }

    public float getKg() {
        return kg;
    }

    public void setKg(float kg) {
        this.kg = kg;
    }
    
    
    
}
