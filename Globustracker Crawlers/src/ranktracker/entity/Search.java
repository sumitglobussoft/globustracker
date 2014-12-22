/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ranktracker.entity;

/**
 *
 * @author Sushant Gupta <sushant@globussoft.com>
 */
public class Search {

    private String keyword;

    /**
     *
     * @return
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     *
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     *
     * @param keyword
     */
    public Search(String keyword) {

        this.keyword = keyword;
    }

    /**
     *
     */
    public Search() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.keyword != null ? this.keyword.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Search other = (Search) obj;
        if ((this.keyword == null) ? (other.keyword != null) : !this.keyword.equals(other.keyword)) {
            return false;
        }
        return true;
    }
}
