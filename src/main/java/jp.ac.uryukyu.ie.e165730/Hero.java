package jp.ac.uryukyu.ie.e165730;


public class Hero extends LivingThing{
    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage){
        setHitPoint(getHitPoint()-damage);
        if( getHitPoint() <= 0 ) {
            setDead(true);
            System.out.println("勇者"+getName()+"は道半ばで倒れてしまった。");
        }
    }
}
