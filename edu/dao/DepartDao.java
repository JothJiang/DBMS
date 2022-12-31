package edu.dao;

public interface DepartDao {
    String getdnames(String dno); //根据学科号获取学科名
    int getask(String dno); //根据学科号获取是否开启助教选课
    void updatesak(int dask,String dno);  //根据学科编号修改助教选课
}
