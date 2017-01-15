package jp.ac.uryukyu.ie.e165730;
import java.util.Random;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    private Random ran = new Random();

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name キャラ名
     * @param maximumHP キャラのHP
     * @param attack キャラの攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }
    public LivingThing () {
        this.name = "CPU";
        hitPoint = 10;
        this.attack = 5;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, 10, attack);
    }
    //private変数のgetter & setter

    public void setDead(boolean dead) { this.dead = dead; }
    /**
     * isDead : getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     * @return boolean
     */
    public boolean isDead(){
        return  dead;
    }

    public void setName(String name) { this.name = name; }
    public String getName(){
        return name;
    }

    public void setAttack(int attack) { this.attack = attack; }
    public int getAttack() { return attack; }

    public void setHitPoint(int hitPoint) { this.hitPoint = hitPoint; }
    public int getHitPoint() { return hitPoint; }

    /**
     * 別のLivingThingへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、livingThing.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(!dead) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
        }
    }

    /**
     * 引数で受け取った確率で計算するメソッド
     * @param odds 強攻撃する確率(%)
     * @return int '1'なら強攻撃，'0'なら普通の攻撃
     */
    public boolean randAttack(int odds){
        int rand;
        rand = ran.nextInt(100);
        if(rand < odds)
            return true;

        return false;
    }
}
