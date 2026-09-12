/* ===== product.js ===== */

document.addEventListener('DOMContentLoaded', function () {

    // ---- Auto-dismiss flash alerts after 4 seconds ----
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(function (alert) {
        setTimeout(function () {
            alert.style.transition = 'opacity 0.5s ease';
            alert.style.opacity = '0';
            setTimeout(function () {
                alert.remove();
            }, 500);
        }, 4000);
    });

    // ---- Save Product form: basic client-side validation ----
    const saveForm = document.getElementById('saveProductForm');
    if (saveForm) {
        saveForm.addEventListener('submit', function (e) {
            const name = document.getElementById('name').value.trim();
            const price = document.getElementById('price').value.trim();
            const coupon = document.getElementById('couponCode').value.trim();

            if (!name) {
                e.preventDefault();
                showInlineError('name', 'Product name is required.');
                return;
            }

            if (!price || isNaN(price) || parseFloat(price) <= 0) {
                e.preventDefault();
                showInlineError('price', 'Enter a valid positive price.');
                return;
            }

            if (!coupon) {
                e.preventDefault();
                showInlineError('couponCode', 'Coupon code is required.');
                return;
            }

            // Show loading state on button
            const btn = saveForm.querySelector('button[type="submit"]');
            if (btn) {
                btn.disabled = true;
                btn.textContent = 'Saving…';
            }
        });
    }

    // ---- Search Product form: validate ID ----
    const searchForm = document.getElementById('searchProductForm');
    if (searchForm) {
        searchForm.addEventListener('submit', function (e) {
            const productId = document.getElementById('productId').value.trim();
            if (!productId || isNaN(productId) || parseInt(productId) <= 0) {
                e.preventDefault();
                showInlineError('productId', 'Enter a valid numeric product ID.');
            }
        });
    }

    // ---- Helper: show an inline error below a field ----
    function showInlineError(fieldId, message) {
        // Remove any previous error for this field
        const existing = document.getElementById('err-' + fieldId);
        if (existing) existing.remove();

        const field = document.getElementById(fieldId);
        if (!field) return;

        const err = document.createElement('small');
        err.id = 'err-' + fieldId;
        err.style.cssText = 'color:#c0392b; font-size:0.82rem; margin-top:4px; display:block;';
        err.textContent = message;

        field.style.borderColor = '#c0392b';
        field.parentNode.appendChild(err);
        field.focus();

        // Clear error on next input
        field.addEventListener('input', function () {
            field.style.borderColor = '';
            const e = document.getElementById('err-' + fieldId);
            if (e) e.remove();
        }, { once: true });
    }

});
