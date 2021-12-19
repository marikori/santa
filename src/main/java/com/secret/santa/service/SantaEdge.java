package com.secret.santa.service;

import org.jgrapht.graph.DefaultEdge;

// Need this to get target, source in service.
public class SantaEdge extends DefaultEdge {
    
    private static final long serialVersionUID = -3004852405652005912L;
    
    @Override
    public Object getSource() {
        return super.getSource();
    }
    
    @Override
    public Object getTarget()
    {
        return super.getTarget();
    }
}
