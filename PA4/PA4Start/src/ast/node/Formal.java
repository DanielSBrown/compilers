/* This file was generated by SableCC (http://www.sablecc.org/). 
 * Then modified.
 */

package ast.node;

import ast.visitor.*;

@SuppressWarnings("nls")
public final class Formal extends Node
{
    private IType _type_;

    private String _name_;
    
    public Formal(int _line_, int _pos_, IType _type_, String _name_)
    {
        super(_line_, _pos_);
        
        setType(_type_);

        setName(_name_);

    }

    @Override
    public int getNumExpChildren() { return 0; }
    
    @Override
    public Object clone()
    {
        return new Formal(
            this.getLine(),
            this.getPos(),
            cloneNode(this._type_),
            this._name_);
    }

    public void accept(Visitor v)
    {
        v.visitFormal(this);
    }

    public IType getType()
    {
        return this._type_;
    }

    public void setType(IType node)
    {
        if(this._type_ != null)
        {
            this._type_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._type_ = node;
    }

    public String getName()
    {
        return this._name_;
    }

    public void setName(String name)
    {
        this._name_ = name;
    }

    @Override
    void removeChild(Node child)
    {
        // Remove child
        if(this._type_ == child)
        {
            this._type_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(Node oldChild, Node newChild)
    {
        // Replace child
        if(this._type_ == oldChild)
        {
            setType((IType) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
