package egovframework.sayit.statusboard.cs;

public class CsVO {
    private String questionContent;
    private String questionRegDate;
    private String questionType;
    private String questionTypeNm;
    private String questionTypeSeq;
    private String frstRegisterPnttm = "";
    private String lastRegisterPnttm = "";

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionRegDate() {
        return questionRegDate;
    }

    public void setQuestionRegDate(String questionRegDate) {
        this.questionRegDate = questionRegDate;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTypeNm() {
        return questionTypeNm;
    }

    public void setQuestionTypeNm(String questionTypeNm) {
        this.questionTypeNm = questionTypeNm;
    }

    public String getQuestionTypeSeq() {
        return questionTypeSeq;
    }

    public void setQuestionTypeSeq(String questionTypeSeq) {
        this.questionTypeSeq = questionTypeSeq;
    }
}
