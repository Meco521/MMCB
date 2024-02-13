/**
 *
 * @author Meco
 * @date 2/13/2024
 */
package dev.mmcb.api.event;

public class CancelableEvent {
    private boolean cancel;

    public void cancelEvent() {
        this.cancel = true;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
