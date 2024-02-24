/**
 * @author Aq1u
 * @date 2/22/2024
 */
package dev.mmcb.api.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelableEvent {
    private boolean cancel;

    public void cancelEvent() {
        this.cancel = true;
    }
}
