package src_jcg284_shg64_hos7_wc523.optimizations;

public interface Data<D extends Data<D>> {
  public static <D extends Data<D>> D getTop() {return null;};
  public D meet(D d);
}
