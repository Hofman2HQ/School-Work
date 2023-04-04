package hw2;

public abstract class Document {
	private String FileName;
	private int WordsInLine;
	private String text;
	
	public Document(String FileName, int WordsInLine, String text)
	{
		this.FileName = FileName;
		this.WordsInLine = WordsInLine;
		this.text = text;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return FileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	/**
	 * @return the wordsInLine
	 */
	public int getWordsInLine() {
		return WordsInLine;
	}
	/**
	 * @param wordsInLine the wordsInLine to set
	 */
	public void setWordsInLine(int wordsInLine) {
		WordsInLine = wordsInLine;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	public abstract void AddText (String moreText);
	public abstract void DeleteAll();
	public abstract boolean IsSame(Document d1);
	public abstract String ToString();
	
}
