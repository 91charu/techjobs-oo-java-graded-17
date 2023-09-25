package org.launchcode.techjobs.oo;
import org.junit.Assert;
import org.junit.Test;
public class JobTest {
    //TODO: Create your unit tests here
@Test
        public void testSettingJobId() {
            Job job1 = new Job();
            Job job2 = new Job();
            Assert.assertNotEquals(job1.getId(), job2.getId());
        }

        @Test
        public void testJobConstructorSetsAllFields() {

            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));

            Assert.assertEquals("Product tester", job.getName());
            Assert.assertTrue(job.getEmployer() instanceof Employer);
            Assert.assertTrue(job.getLocation() instanceof Location);
            Assert.assertTrue(job.getPositionType() instanceof PositionType);
            Assert.assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

            Assert.assertEquals("ACME", job.getEmployer().getValue());
            Assert.assertEquals("Desert", job.getLocation().getValue());
            Assert.assertEquals("Quality control", job.getPositionType().getValue());
            Assert.assertEquals("Persistence", job.getCoreCompetency().getValue());
        }

        @Test
        public void testJobsForEquality() {

            Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));
            Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));
            Assert.assertFalse(job1.equals(job2));
        }

}
