package nl.bldn.projects.applesandoranges.model;

public class FruityMessage {
    private final String header;
    private final String body;

    public FruityMessage(String header, String body) {
        this.header = header;
        this.body = body;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FruityMessage that = (FruityMessage) o;

        if (header != null ? !header.equals(that.header) : that.header != null) return false;
        return body != null ? body.equals(that.body) : that.body == null;
    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[header: " + header + ", body: " + body + "]";
    }
}
