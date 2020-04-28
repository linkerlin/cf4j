package es.upm.etsisi.cf4j.recommender.matrixFactorization;

import es.upm.etsisi.cf4j.data.DataModel;
import es.upm.etsisi.cf4j.data.MockDataSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NMFTest {

    final private static int seed = 69;
    final private static int numFactors = 2;
    final private static int numIters = 1;

    final private static int testUserId = 1;
    final private static int testItemId = 1;

    private static DataModel datamodel;

    @BeforeAll
    static void initAll() {
        datamodel = new DataModel(new MockDataSet());

    }

    @Test
    void nmfTest(){
        NMF nmf = new NMF(datamodel,numFactors,numIters,seed);
        nmf.fit();

        assertEquals(3.9744683282488125, nmf.predict(testUserId,testItemId));
        assertEquals(nmf.predict(testUserId,testItemId), nmf.predict(datamodel.getTestUser(testUserId))[testItemId]);

        assertEquals(numFactors, nmf.getNumFactors());
        assertEquals(numIters, nmf.getNumIters());
    }
}