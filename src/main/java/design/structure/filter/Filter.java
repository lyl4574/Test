package design.structure.filter;

public interface Filter {
    void doFilter(Request req, Response resp, FilterChain chain);
}
 

