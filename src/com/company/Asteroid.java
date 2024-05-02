package com.company;

class asteroid {
    private String name;
    private double p;

    public String getName() {
        return name;
    }

    public double getP() {
        return p;
    }

    asteroid(String name,double p){
        this.name=name;
        this.p=p;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setP(double p) {
        this.p = p;
    }
   }

class comet extends asteroid{
    private double taillength;
    comet(String name,double p,double taillength){
        super(name,p);
        this.taillength = taillength;
    }

    public double getTaillength() {
        return taillength;
    }

    public void setTaillength(double tail) {
        this.taillength = tail;
    }
    public void description() {
        System.out.println("Имя кометы "+getName()+", период ее вращения "+getP()+" года/лет, а длина хвоста равна "+taillength+"млн.км");
    }
}