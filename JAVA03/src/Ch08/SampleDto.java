package Ch08;

public class SampleDto {
	private String 위반구분;
	private String 위반일시;
	private String 위반장소;
	private String 과태료부과일자;
	private String 데이터기준일자;
	//기본생성자
	public SampleDto() {}
	//모든인자 생성자
	public SampleDto(String 위반구분, String 위반일시, String 위반장소, String 과태료부과일자, String 데이터기준일자) {
		super();
		this.위반구분 = 위반구분;
		this.위반일시 = 위반일시;
		this.위반장소 = 위반장소;
		this.과태료부과일자 = 과태료부과일자;
		this.데이터기준일자 = 데이터기준일자;
	}
	
	
	//Getter and Setter
	public String get위반구분() {
		return 위반구분;
	}
	public void set위반구분(String 위반구분) {
		this.위반구분 = 위반구분;
	}
	public String get위반일시() {
		return 위반일시;
	}
	public void set위반일시(String 위반일시) {
		this.위반일시 = 위반일시;
	}
	public String get위반장소() {
		return 위반장소;
	}
	public void set위반장소(String 위반장소) {
		this.위반장소 = 위반장소;
	}
	public String get과태료부과일자() {
		return 과태료부과일자;
	}
	public void set과태료부과일자(String 과태료부과일자) {
		this.과태료부과일자 = 과태료부과일자;
	}
	public String get데이터기준일자() {
		return 데이터기준일자;
	}
	public void set데이터기준일자(String 데이터기준일자) {
		this.데이터기준일자 = 데이터기준일자;
	}
	//toString
	@Override
	public String toString() {
		return "SampleDto [위반구분=" + 위반구분 + ", 위반일시=" + 위반일시 + ", 위반장소=" + 위반장소 + ", 과태료부과일자=" + 과태료부과일자 + ", 데이터기준일자="
				+ 데이터기준일자 + "]";
	}

	
	
}
