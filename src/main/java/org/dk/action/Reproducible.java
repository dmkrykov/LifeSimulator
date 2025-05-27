package org.dk.action;

import org.dk.nature.Natures;

// Интерфейс для сущностей, которые могут размножаться
@FunctionalInterface
public interface Reproducible {
    Natures reproduce();
}
