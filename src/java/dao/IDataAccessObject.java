/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author julio
 */
public interface IDataAccessObject<T> {
    public void create(T entity) throws Exception;
    public void remove(int id) throws Exception;
    public List<T> getAll() throws Exception;
    public T getOne(int id) throws Exception;
}
