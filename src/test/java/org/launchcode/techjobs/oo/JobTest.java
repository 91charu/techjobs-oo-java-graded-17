package org.launchcode.techjobs.oo;
import static org.junit.Assert.*;
import org.junit.Test;

public class JobTest {
    //TODO: Create your unit tests here
@Test
        public void testSettingJobId() {
            Job job1 = new Job();
            Job job2 = new Job();
            assertNotEquals(job1.getId(), job2.getId());
        }
        @Test
        public void testJobConstructorSetsAllFields() {

            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));

            assertEquals("Product tester", job.getName());
            assertTrue(job.getEmployer() instanceof Employer);
            assertTrue(job.getLocation() instanceof Location);
            assertTrue(job.getPositionType() instanceof PositionType);
            assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

            assertEquals("ACME", job.getEmployer().getValue());
            assertEquals("Desert", job.getLocation().getValue());
            assertEquals("Quality control", job.getPositionType().getValue());
            assertEquals("Persistence", job.getCoreCompetency().getValue());
        }

        @Test
        public void testJobsForEquality() {

            Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));
            Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                    new PositionType("Quality control"), new CoreCompetency("Persistence"));
            assertFalse(job1.equals(job2));
        }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobToString = job.toString();

        String expectedOutput = String.format(
                "%nID: %d%nName: Product tester%nEmployer: ACME%nLocation: Desert%nPosition Type: Quality control%nCore Competency: Persistence%n",
                job.getId());

        assertEquals(expectedOutput, jobToString);
    }



    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Job Title", new Employer("Employer"), new Location("Location"),
                new PositionType("Position Type"), new CoreCompetency("Core Competency"));

        String jobString = job.toString().trim();

        String expectedString = String.format(
                "ID: %s%nName: %s%nEmployer: %s%nLocation: %s%nPosition Type: %s%nCore Competency: %s",job.getId(),
                job.getName(), job.getEmployer(), job.getLocation(), job.getPositionType(), job.getCoreCompetency());
        // System.out.println("Actual String:");
        // System.out.println(jobString);

        // Print lengths of expected and actual strings
        //System.out.println("Expected length: " + expectedString.length());
        // System.out.println("Actual length: " + jobString.length());


        assertEquals(expectedString, jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"),
                new PositionType(""), new CoreCompetency("Java"));
        String jobString = job.toString().trim();
        String expectedOutput = String.format( "ID: " + job.getId() + "%n"  +
                "Name: Web Developer%n" +
                "Employer: Data not available%n" +
                "Location: StL%n" +
                "Position Type: Data not available%n" +
                "Core Competency: Java");
        assertEquals(expectedOutput, jobString);
    }
}
