package org.minions.devfund.richard.whackamole;

/**
 * Interface.
 */
public interface MatrixActions {

    /**
     * @param moleGrid        This variable is the array.
     * @param row             This variable is the row.
     * @param column          This variable is the column.
     * @param myStreamBuilder This variable is the Stream Builder.
     */
    void action(char[][] moleGrid, int row, int column, StringBuilder myStreamBuilder);
}
