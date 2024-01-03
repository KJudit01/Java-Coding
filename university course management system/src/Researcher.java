public class Researcher implements Enrollable{
    private String name;
    private String researchArea;
    private int yearsOfResearchExperience;

    public Researcher(String name, String researchArea, int yearsOfResearchExperience) {
        this.name = name;
        this.researchArea = researchArea;
        this.yearsOfResearchExperience = yearsOfResearchExperience;
    }

    @Override
    public String toString() {
        return String.format("+----------------------------------------------+\n" +
                        "| Name:                             %-10s |\n" +
                        "| Research Area:                    %-10s |\n" +
                        "| Years of Experience:              %-10d |\n" +
                        "+----------------------------------------------+",
                name,researchArea,yearsOfResearchExperience);
    }
}
