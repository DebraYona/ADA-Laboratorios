

package laboratorio1;

/**
 *
 *
 */
public abstract class Assurance {

    private int _policy;
    private String _name;
    private float _premium;
    private double _commission;
    private double _coverage;

    public Assurance(int policy, String name, float commision) {
        _policy = policy;
        _name = name;
        _premium = 0;
        _commission = commision;
        _coverage = 0;
    }

    public abstract void calculatePremium();
    public abstract void calculateCoverage();
    
    
    public int getPolicy() {
        return _policy;
    }

    public void setPolicy(int _policy) {
        this._policy = _policy;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public float getPremium() {
        return _premium;
    }

    public void setPremium(float _premium) {
        this._premium = _premium;
    }

    public double getCommission() {
        return _commission;
    }

    public void setCommission(double _commission) {
        this._commission = _commission;
    }

    public double getCoverage() {
        return _coverage;
    }

    public void setCoverage(double _coverage) {
        this._coverage = _coverage;
    }

    
    
    
}