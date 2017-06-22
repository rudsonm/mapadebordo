/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author julio
 */
public interface IDataAccessObject<T> {
    public void insert(T entity);
    public void delete(int id);
    public void get();
}
