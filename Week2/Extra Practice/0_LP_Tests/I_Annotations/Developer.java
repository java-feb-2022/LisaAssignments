public class Developer {
    @Override // fyi compiler, we're overriding a parent method
    public String getName() {
        return "Developer!";
    }
}
// @Deprecated tells people compiling the code that this method is ingrained, but is outdated
// -Xlint:deprecation (try compiling your code on the CLI using this flag)