package org.pdsw.pbt;

import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;
import org.pdsw.pbt.triangle.Classifier;
import org.pdsw.pbt.triangle.TriangleType;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class ClassifierTest {

    @Test
    public void addingTwoPositiveIntegersAlwaysGivesAPositiveInteger(){
      Classifier classifier = new Classifier();
      PBTClassifier pbtClassifier = new PBTClassifier("addingTwoPositiveIntegersAlwaysGivesAPositiveInteger");

      qt()
      .forAll(integers().between(-1, 20)
             , integers().between(-1, 20)
             , integers().between(-1, 20))
      .check((a,b,c) -> {
            TriangleType classification = classifier.classify(a, b, c);

            if (a <= 0 || b <= 0 || c <= 0) {
              pbtClassifier.collect("Not a triangle");              
              return classification == TriangleType.NotATriangle;
            }else if (a+b < c || b+c < a || a+c < 0) {
            	pbtClassifier.collect("Not a triangle");              
                return classification == TriangleType.NotATriangle;          	
            }else if (a == b && b == c) {
            	pbtClassifier.collect("Equilateral");              
                return classification == TriangleType.Equilateral;
            }else if (a == b || b == c || a == c) {
            	pbtClassifier.collect("Isosceles");              
                return classification == TriangleType.Isosceles;
            }else {
            	pbtClassifier.collect("Scalene");              
                return classification == TriangleType.Scalene;
            }
          }); 
      pbtClassifier.results();
  }
}